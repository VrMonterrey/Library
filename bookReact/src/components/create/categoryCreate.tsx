import {
  Create,
  required,
  SimpleForm,
  TextInput,
  useCreate,
} from "react-admin";

export const CategoryCreate = () => {
  const [create] = useCreate();

  const onCreate = (data: any) => {
    create("categories", { data: [data] });
  };

  return (
    <Create>
      <SimpleForm onSubmit={onCreate}>
        <TextInput source="name" validate={[required()]} />
      </SimpleForm>
    </Create>
  );
};
